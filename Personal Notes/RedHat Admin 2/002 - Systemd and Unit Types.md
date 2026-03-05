# Systemd and Unit Types

## Init Systems
| System | Era | Characteristics |
|--------|-----|----------------|
| **SysVinit** | Legacy | Sequential, script-based, slow, runlevels 0-6 |
| **Systemd** | Modern | Parallel startup, unit files, targets |

## Systemd Performance Analysis
- `systemd-analyze` — total boot time.
- `systemd-analyze blame` — services sorted by startup time.
- `systemd-analyze plot > boot.svg` — visual boot timeline.

## Unit Types
| Extension | Purpose |
|-----------|---------|
| `.service` | Background daemons (sshd, httpd) |
| `.socket` | Port-based activation |
| `.mount` | Mount points |
| `.automount` | Mount on access |
| `.timer` | Scheduled services (replaces Cron) |
| `.target` | Groups of units (system states) |

## Unit File Structure (`/etc/systemd/system/`)
- **[Unit]**: Description, dependencies (`After=network.target`).
- **[Service]**: `ExecStart`, `User`, `Restart` behavior.
- **[Install]**: Which target wants this (`WantedBy=multi-user.target`).

## Related
- [[003 - Service Management with systemctl]]
- [[004 - Systemd Targets]]
