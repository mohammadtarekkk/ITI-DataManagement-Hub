# Service Management with systemctl

## Basic Control
| Command | Action |
|---------|--------|
| `systemctl start svc` | Start now |
| `systemctl stop svc` | Stop now |
| `systemctl restart svc` | Stop then start (new PID) |
| `systemctl reload svc` | Reread config (same PID) |

## Boot Configuration
| Command | Action |
|---------|--------|
| `systemctl enable svc` | Start at boot |
| `systemctl disable svc` | Don't start at boot |
| `systemctl enable --now svc` | Enable + start immediately |

## Status
| Command | Returns |
|---------|---------|
| `systemctl status svc` | Detailed info + recent logs |
| `systemctl is-active svc` | "active" / "inactive" |
| `systemctl is-enabled svc` | "enabled" / "disabled" |

## Advanced States
- **Masked**: Linked to `/dev/null`. Cannot be started at all.
  - `systemctl mask svc` / `systemctl unmask svc`
- **Static**: No `[Install]` section. Only runs as a dependency.

## Related
- [[002 - Systemd and Unit Types]]
- [[005 - Journald Logging]]
