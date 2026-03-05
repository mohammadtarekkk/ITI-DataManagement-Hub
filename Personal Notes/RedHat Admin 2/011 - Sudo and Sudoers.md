# Sudo and Sudoers

## Purpose
Allows users to execute commands as **root** (or another user) without switching accounts.

## Configuration
- File: `/etc/sudoers`
- **Always edit with**: `visudo` (performs syntax checks).

## Sudoers Syntax
```
user host=(runas_user) [NOPASSWD:] commands
```
- Example: `sarah ALL=(ALL) ALL` — full root access.
- Example: `ahmed ALL=(ALL) /bin/ls, /bin/cat` — limited commands.

## Aliases
Group users or commands for easier management:
- `User_Alias ADMINS = user1, user2`
- `Cmnd_Alias STORAGE = /bin/mount, /bin/umount`

## `su` vs `sudo`
| Feature | `su` | `sudo` |
|---------|------|--------|
| Action | Switches user session | Executes single command |
| Password | Target user's password | Current user's password |
| Audit trail | Minimal | Full logging |

## Related
- [[007 - User and Group Administration]]
- [[008 - Ownership and Permissions]]
