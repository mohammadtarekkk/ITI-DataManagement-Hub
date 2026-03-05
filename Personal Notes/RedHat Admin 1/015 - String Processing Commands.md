# String Processing Commands

## `wc` (Word Count)
- `-l` lines, `-w` words, `-c` characters.

## `diff`
Compares two files and shows differences.

## `grep` (Search)
| Option | Action |
|--------|--------|
| `-i` | Ignore case |
| `-v` | Invert (show non-matching) |
| `-n` | Show line numbers |
| `-c` | Count matching lines |
| `-w` | Match whole words only |

## `tr` (Translate)
Changes or deletes characters from stdin.
- `tr 'a-z' 'A-Z'` — lowercase to uppercase.

## `cut` (Extract Fields)
- `-f N` — field number.
- `-d ':'` — delimiter (default TAB).
- Example: `cut -d: -f1 /etc/passwd` — extract usernames.

## `sort`
| Option | Action |
|--------|--------|
| `-t` | Delimiter |
| `-k N` | Sort by column N |
| `-n` | Numerical sort |
| `-o file` | Output to file |

## Related
- [[014 - IO Redirection and Pipelines]]
- [[004 - Listing and Viewing Files]]
