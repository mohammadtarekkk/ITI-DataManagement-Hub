# Aliases and Command History

## Aliases
Shortcuts for frequently used commands.
- **Create**: `alias ll='ls -l'`
- **View all**: `alias`
- **Remove**: `unalias ll`
- **Bypass**: Use full path (`/usr/bin/ls`) or backslash (`\ls`).

## Command History
Stored in `~/.bash_history`.

| Shortcut | Action |
|----------|--------|
| `↑` / `↓` | Scroll through history |
| `!!` | Repeat last command |
| `!string` | Repeat last command starting with `string` |
| `!n` | Repeat command number `n` |
| `!-n` | Repeat command `n` steps back |
| `^old^new` | Repeat last command, replacing `old` with `new` |

## Related
- [[010 - Initialization Files and Environment Variables]]
- [[002 - Command Syntax and Help]]
