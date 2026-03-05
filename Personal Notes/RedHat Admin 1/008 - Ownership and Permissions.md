# Ownership and Permissions

## Ownership
Every file has a **User** owner and a **Group** owner.
- `chown user:group file` — change both.
- `chown user file` — change user only.
- `chown :group file` — change group only.

## Permission Types
| Permission | File | Directory |
|------------|------|-----------|
| **Read (r)** | View content | List contents |
| **Write (w)** | Modify content | Create/delete files inside |
| **Execute (x)** | Run as program | Access (`cd`) into it |

## Changing Permissions (`chmod`)
### Symbolic Mode
`chmod [who][operator][permission] file`
- **Who**: `u` (user), `g` (group), `o` (others), `a` (all).
- **Operator**: `+` (add), `-` (remove), `=` (set exactly).

### Octal Mode
| Value | Permission |
|-------|-----------|
| 4 | Read |
| 2 | Write |
| 1 | Execute |
- Example: `chmod 755 file` → User: rwx, Group: r-x, Others: r-x.

## Default Permissions (`umask`)
- `umask` sets default permissions for new files/directories.
- New file max: `666`, New directory max: `777`.
- `umask 022` → Files: `644`, Dirs: `755`.

## Related
- [[007 - User and Group Administration]]
- [[009 - Special Permissions]]
- [[010 - Access Control Lists]]
