# User and Group Administration

## Configuration Files
| File | Purpose |
|------|---------|
| `/etc/passwd` | User accounts (`login:x:UID:GID:comment:home:shell`) |
| `/etc/shadow` | Encrypted passwords & aging info |
| `/etc/group` | Group info (`groupname:x:GID:members`) |
| `/etc/gshadow` | Secure group info |

## User Management
- `useradd username` — create user (home populated from `/etc/skel`).
- `useradd -D` — view/modify defaults.
- `passwd username` — set/change password.
- `newusers file` — bulk create users from file.
- `usermod -l` — rename login. `-L` lock, `-U` unlock.
- `userdel username` — delete user. `-r` removes home & mail.

## Password Aging (`chage`)
- `-m` min days, `-M` max days, `-E` expiry date, `-W` warning days.

## Group Management
- `groupadd`, `groupmod`, `groupdel` — create/modify/delete groups.
- `gpasswd` — manage group members/admins.
- Each user gets a **Private Group** with the same name as their username.

## Identity Commands
| Command | Purpose |
|---------|---------|
| `whoami` | Current effective username |
| `id` | UID, GID, groups |
| `who` / `w` | Logged-in users |
| `groups` | Current user's groups |
| `su - user` | Switch user (with environment) |
| `newgrp group` | Switch active group |

## Related
- [[008 - Ownership and Permissions]]
- [[011 - Sudo and Sudoers]]
