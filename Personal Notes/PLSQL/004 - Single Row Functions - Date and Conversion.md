# Single Row Functions: Date and Conversion

## Date Functions
Oracle stores dates internally as numeric values (Century, Year, Month, Day, Hours, Minutes, Seconds).
- `SYSDATE`: Returns the current database server date and time.
- Standard arithmetic: `date + number = date` (adds days).

| Function | Description | Example |
|----------|-------------|---------|
| `MONTHS_BETWEEN(d1, d2)` | Number of months between | `MONTHS_BETWEEN(sysdate, hire_date)` |
| `ADD_MONTHS(d, n)` | Adds `n` calendar months | `ADD_MONTHS(sysdate, 6)` |
| `NEXT_DAY(d, 'Day')` | Next specific weekday | `NEXT_DAY(sysdate, 'Sunday')` |
| `LAST_DAY(d)` | Last day of the month | `LAST_DAY(sysdate)` |
| `ROUND(d, 'Month/Year')` | Rounds to nearest month/year| `ROUND(sysdate, 'Month')` |
| `TRUNC(d, 'Month/Year')` | Truncates to start of month/Yr| `TRUNC(sysdate, 'Year')` |

## Conversion Functions (Casting)
Converts data from one type to another explicitly.

### `TO_CHAR` (Number/Date → String)
Allows custom formatting.
```sql
-- Formatting Dates
SELECT TO_CHAR(sysdate, 'dd-mm-yyyy HH24:Mi:SS') FROM dual;
SELECT TO_CHAR(hire_date, 'dd FMMonth yyyy') FROM employees;

-- Formatting Numbers (Money)
SELECT TO_CHAR(salary, '9,999,999.99') || ' EGP' FROM employees;
```

### `TO_DATE` (String → Date)
Converts a string formatted date into a pure date type so it can be queried.
```sql
SELECT last_name FROM employees 
WHERE hire_date = TO_DATE('17-06-1987', 'dd-mm-yyyy');
```

### `TO_NUMBER` (String → Number)
Converts a formatted string into a usable number for arithmetic.
```sql
SELECT TO_NUMBER('24,108.00', '99,999.99') + 500 FROM dual;
```

## Related
- [[003 - Single Row Functions - Character and Number]]
