# Special Permissions

Beyond standard `rwx`, Linux has three special permission bits.

## SetUID (`u+s`)
- File executes with the **owner's** privileges, not the runner's.
- Numeric: **4** (e.g., `chmod 4755 file`).
- Example: `/usr/bin/passwd` lets normal users change passwords.

## SetGID (`g+s`)
- **On File**: Executes with the **group owner's** privileges.
- **On Directory**: New files inherit the directory's **group owner**.
- Numeric: **2** (e.g., `chmod 2755 dir`).

## Sticky Bit (`o+t`)
- **On Directory**: Users can only delete files they **own**, even with write access.
- Numeric: **1** (e.g., `chmod 1777 /tmp`).

## Case Sensitivity
| Symbol | Meaning |
|--------|---------|
| Lowercase `s` / `t` | Permission set **AND** execute present |
| Uppercase `S` / `T` | Permission set **BUT** execute missing |

## Related
- [[008 - Ownership and Permissions]]
- [[010 - Access Control Lists]]
