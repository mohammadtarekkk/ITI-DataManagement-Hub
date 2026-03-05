# Job Control

Manage foreground and background processes in the shell.

## Backgrounding
- `command &` — run a command in the background.
- `Ctrl+Z` — suspend the current foreground process.

## Commands
| Command | Action |
|---------|--------|
| `jobs` | List background/stopped jobs |
| `fg %n` | Bring job `n` to foreground |
| `bg %n` | Resume stopped job `n` in background |

## Related
- [[012 - Processes and Signals]]
- [[014 - IO Redirection and Pipelines]]
