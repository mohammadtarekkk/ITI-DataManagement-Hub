# I/O Redirection and Pipelines

## Standard Streams
| Stream | FD | Default |
|--------|-----|---------|
| **stdin** | 0 | Keyboard |
| **stdout** | 1 | Screen |
| **stderr** | 2 | Screen |

## Redirection
| Operator | Action |
|----------|--------|
| `>` | Redirect stdout to file (overwrite) |
| `>>` | Redirect stdout to file (append) |
| `<` | Read stdin from file |
| `2>` | Redirect stderr to file |
| `2>&1` | Redirect stderr to stdout |
| `&>` | Redirect both stdout and stderr |

## Pipelines
- `command1 | command2` — output of `command1` becomes input of `command2`.
- Example: `ls -l | grep ".txt" | wc -l`

## `tee` Command
Reads from stdin and writes to **both** stdout and a file.
- `ls | tee output.txt` — displays and saves.

## Related
- [[015 - String Processing Commands]]
- [[013 - Job Control]]
