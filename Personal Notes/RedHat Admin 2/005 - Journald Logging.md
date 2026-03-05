# Journald Logging

**Journald** is the binary logging system integrated into systemd.

## Commands
| Command | Action |
|---------|--------|
| `journalctl` | View all logs |
| `journalctl -u svc` | Logs for a specific service |
| `journalctl -f` | Real-time monitoring (like `tail -f`) |
| `journalctl -b` | Current boot only |
| `journalctl -xe` | Recent errors with explanations |
| `journalctl --since "10 min ago"` | Filter by time |

## Related
- [[006 - Rsyslog and Log Management]]
- [[003 - Service Management with systemctl]]
