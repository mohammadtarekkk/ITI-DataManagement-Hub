# One-Time Scheduling with at

Schedule a task to run **once** at a specific future time.

## Requirement
`atd` daemon must be running: `systemctl start atd`.

## Time Formats
`at 15:00`, `at now + 5 min`, `at teatime tomorrow`, `at 5pm August 3`

## Scheduling Methods
1. **Interactive**: `at TIME` → type commands → `Ctrl+D`.
2. **Pipeline**: `echo "script.sh" | at 14:30`.
3. **Redirect**: `at now < script.sh`.

## Managing Jobs
| Command | Action |
|---------|--------|
| `atq` | List pending jobs |
| `atrm job_id` | Remove a job |
| `at -c job_id` | View job script content |

## Access Control
- `/etc/at.allow` — if exists, **only** listed users can use `at`.
- `/etc/at.deny` — if `at.allow` absent, listed users are blocked.
- If neither exists, only **root** can use `at`.

## Related
- [[008 - Cron Scheduling]]
- [[003 - Service Management with systemctl]]
