import csv
import json
import sys
import yaml
import os

def load_config(config_path):
    with open(config_path, 'r') as file:
        return yaml.safe_load(file)

def load_orders(orders_path):
    with open(orders_path, 'r') as file:
        return json.load(file)

def load_customers(customers_path, delimiter):
    with open(customers_path, 'r') as file:
        lines = file.readlines()
        return [line.strip().split(delimiter) for line in lines[1:]]

def calculate_age_group(age):
    age_val = int(age)
    if age_val < 25:
        return 'Young'
    elif 25 <= age_val <= 45:
        return 'Mid'
    else:
        return 'Old'

def main():
    if len(sys.argv) < 2:
        sys.exit(1)

    config_path = sys.argv[1]
    config = load_config(config_path)

    src = config['source']
    dest = config['destination']

    orders_path = os.path.join(src['input_dir'], src['orders']['file'])
    customers_path = os.path.join(src['input_dir'], src['customers']['file'])
    delimiter = src['customers'].get('delimiter', '|')

    orders = load_orders(orders_path)
    customers_raw = load_customers(customers_path, delimiter)

    customer_lookup = {}
    for c in customers_raw:
        if len(c) >= 3:
            cid = c[0]
            age = c[2]
            customer_lookup[cid] = calculate_age_group(age)

    stats = {'Young': [], 'Mid': [], 'Old': []}

    for order in orders:
        age_grp = customer_lookup.get(str(order['customer_id']))
        if age_grp:
            stats[age_grp].append(float(order['amount']))

    report_data = []
    for grp in ['Young', 'Mid', 'Old']:
        amounts = stats[grp]
        if amounts:
            report_data.append({
                'age_group': grp,
                'SUM': round(sum(amounts), 2),
                'AVG': round(sum(amounts) / len(amounts), 2),
                'MAX': max(amounts),
                'MIN': min(amounts)
            })

    if not os.path.exists(dest['output_dir']):
        os.makedirs(dest['output_dir'])

    output_file = os.path.join(dest['output_dir'], dest['report_file'])
    with open(output_file, 'w', newline='') as file:
        fieldnames = ['age_group', 'SUM', 'AVG', 'MAX', 'MIN']
        writer = csv.DictWriter(file, fieldnames=fieldnames)
        writer.writeheader()
        writer.writerows(report_data)

if __name__ == "__main__":
    main()