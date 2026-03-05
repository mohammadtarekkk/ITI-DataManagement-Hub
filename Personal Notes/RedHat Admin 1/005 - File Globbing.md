# File Globbing (Wildcards)

File globbing uses metacharacters to match filenames in the shell.

## Wildcards
| Pattern | Meaning | Example |
|---------|---------|---------|
| `*` | Zero or more characters | `*.txt` matches all `.txt` files |
| `?` | Exactly one character | `file?.txt` matches `file1.txt` |
| `[abc]` | Any one character in brackets | `[aA]*.txt` |
| `[a-z]` | Any one character in range | `file[0-9].log` |

> [!TIP]
> Globbing is handled by the **shell**, not the command itself. The shell expands the pattern before passing it to the command.

## Related
- [[004 - Listing and Viewing Files]]
- [[006 - File and Directory Manipulation]]
