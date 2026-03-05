# Rsyslog and Log Management

## Rsyslog
A system that collects, processes, and forwards log messages.
- Check: `systemctl status rsyslog`

## Core Log Files (`/var/log/`)
| File | Content |
|------|---------|
| `/var/log/messages` | General system logs (RHEL) |
| `/var/log/secure` | Authentication/security logs (RHEL) |
| `/var/log/maillog` | Mail system |
| `/var/log/cron` | Cron job logs |
| `/var/log/dmesg` | Kernel hardware detection |

## Syslog Priorities (0 = most severe)
`emerg` → `alert` → `crit` → `err` → `warning` → `notice` → `info` → `debug`

## Custom Logging
- Config: `/etc/rsyslog.d/custom.conf`
- Example: `local0.* /var/log/customapp.log`
- Test: `logger -p local0.info "Test message"`
- Apply: `systemctl restart rsyslog`

## Logrotate
Automatically rotates, compresses, and removes old logs.
- Config: `/etc/logrotate.conf` and `/etc/logrotate.d/`
- Settings: `weekly`, `rotate 4`, `compress`, `create`, `notifempty`.

## Related
- [[005 - Journald Logging]]
- [[003 - Service Management with systemctl]]
