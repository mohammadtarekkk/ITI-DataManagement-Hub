# Single Row Functions: Character and Number

Single-row functions return one result per row processed. They can be nested.

## Character Functions
Manipulate string values.

### Case Conversion
- `UPPER('String')` → `STRING`
- `LOWER('String')` → `string`
- `INITCAP('hello world')` → `Hello World`

### Character Manipulation
| Function | Description | Example | Result |
|----------|-------------|---------|--------|
| `CONCAT(a, b)` | Joins two values | `CONCAT('A', 'B')` | `'AB'` |
| `LENGTH(str)` | Returns string length | `LENGTH('Ahmed')` | `5` |
| `SUBSTR(str, pos, len)` | Extracts substring | `SUBSTR('Hello', 2, 3)` | `'ell'` |
| `INSTR(str, search)` | Finds position of string | `INSTR('Hello', 'l')` | `3` |
| `REPLACE(str, old, new)` | Replaces characters | `REPLACE('A_B', '_', ' ')` | `'A B'` |
| `TRIM(str)` | Removes leading/trailing spaces| `TRIM(' Hello ')` | `'Hello'` |

*Example: Extracting a username from an email*
```sql
SELECT substr(email, 1, instr(email, '@') - 1) AS user_name 
FROM employees;
```

## Number Functions
Manipulate numeric data.

| Function | Description | Example | Result |
|----------|-------------|---------|--------|
| `ROUND(num, dec)` | Rounds to decimal places | `ROUND(15.789, 2)` | `15.79` |
| `TRUNC(num, dec)` | Truncates (cuts) decimals | `TRUNC(15.789, 2)` | `15.78` |
| `MOD(num, divisor)` | Returns remainder | `MOD(15, 4)` | `3` |

*Example: Calculating complete boxes and leftovers*
```sql
SELECT trunc(700 / 9) AS full_boxes, MOD(700, 9) AS leftovers FROM dual;
```

## Related
- [[004 - Single Row Functions - Date and Conversion]]
