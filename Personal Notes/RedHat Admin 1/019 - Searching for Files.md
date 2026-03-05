# Searching for Files

## `locate`
Searches a **pre-built database** — very fast but may be stale.
- `locate filename`
- `updatedb` — refresh the database.

## `find`
Searches the **live filesystem** — slower but powerful and always current.

| Option | Action |
|--------|--------|
| `-name "*.txt"` | Search by name (glob) |
| `-user username` | Search by owner |
| `-size +10M` | Larger than 10 MB |
| `-mtime -7` | Modified in last 7 days |
| `-type f` | Files only |
| `-type d` | Directories only |

- Example: `find /home -name "*.log" -mtime -30`

## Related
- [[018 - Package Management]]
- [[005 - File Globbing]]
