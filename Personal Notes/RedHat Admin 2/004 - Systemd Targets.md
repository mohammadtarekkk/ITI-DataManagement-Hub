# Systemd Targets

Targets define the **system's current operational state** (replacing SysVinit runlevels).

## Common Targets
| Target | Runlevel | Description |
|--------|----------|-------------|
| `graphical.target` | 5 | Multi-user + GUI |
| `multi-user.target` | 3 | Multi-user, CLI only |
| `rescue.target` | 1 | Single-user, basic services |
| `emergency.target` | — | Minimal, root FS read-only |

## Commands
| Command | Action |
|---------|--------|
| `systemctl get-default` | Show current default target |
| `systemctl set-default target` | Change boot default |
| `systemctl isolate target` | Switch target **now** (no reboot) |

## Related
- [[001 - Linux Boot Sequence]]
- [[002 - Systemd and Unit Types]]
