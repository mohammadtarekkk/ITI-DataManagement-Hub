# Initialization Files and Environment Variables

## Startup Files
### Global (All Users)
| File | When Executed |
|------|---------------|
| `/etc/profile` | Login shells & desktop sessions |
| `/etc/bash.bashrc` | Every bash invocation |

### User-Specific (`~/`)
| File | When Executed |
|------|---------------|
| `~/.profile` | GUI login & console login |
| `~/.bash_profile` | Bash login shells (overrides `.profile`) |
| `~/.bashrc` | Every bash invocation + graphical login |

## Environment Variables
| Variable | Purpose |
|----------|---------|
| `$HOME` | Home directory path |
| `$PATH` | Directories searched for executables |
| `$PWD` | Current working directory |
| `$SHELL` | Login shell path |
| `$USER` | Current username |
| `$HOSTNAME` | Computer name |

- `echo $VAR` — view a variable.
- `set` — view all variables.

## Related
- [[011 - Aliases and Command History]]
- [[001 - Linux Overview]]
