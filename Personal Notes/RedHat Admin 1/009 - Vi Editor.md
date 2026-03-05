# Vi Editor

The default text editor for all Unix/Linux systems. Linux uses **Vim** (Vi Improved) with syntax highlighting and mouse support.

## Three Modes
1. **Command Mode** (Default): Navigate, copy, delete.
2. **Insert Mode**: Type text. Enter with `i`, `a`, `o`, etc. Exit with `Esc`.
3. **Last Line Mode**: Save, quit, search. Enter with `:` from Command mode.

## Entering Insert Mode
| Key | Action |
|-----|--------|
| `i` | Insert before cursor |
| `a` | Append after cursor |
| `I` | Insert at beginning of line |
| `A` | Append at end of line |
| `o` | New line below |
| `O` | New line above |

## Navigation (Command Mode)
- `h j k l` — Left, Down, Up, Right.
- `w` / `b` — Forward/Back one word.
- `0` — Beginning of line. `G` — End of file. `nG` — Line n.
- `Ctrl+F` / `Ctrl+B` — Page forward/back.

## Editing
- `x` — Delete char. `dw` — Delete word. `dd` — Delete line.
- `yy` — Copy line. `p` — Paste below. `P` — Paste above.
- `/string` — Search forward. `?string` — Search backward.
- `:%s/old/new/g` — Global search & replace.

## Saving & Quitting
| Command | Action |
|---------|--------|
| `:w` | Save |
| `:wq` / `:x` / `ZZ` | Save and quit |
| `:q!` | Quit without saving |

## Related
- [[002 - Command Syntax and Help]]
- [[010 - Initialization Files and Environment Variables]]
