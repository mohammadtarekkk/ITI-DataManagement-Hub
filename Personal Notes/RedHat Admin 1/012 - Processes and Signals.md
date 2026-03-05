# Processes and Signals

## What is a Process?
Every running program creates a **Process** with a unique **PID** (Process ID).
- **Daemons**: Background system processes providing services.
- **Parent/Child**: A process can spawn child processes; parent waits for child to finish.

## Process Priority (Niceness)
- Range: **-20** (highest priority) to **+19** (lowest).
- Default: **0**.
- Regular users can only **increase** niceness (lower priority).
- Only **root** can decrease niceness (raise priority).
- `nice -n 10 command` — start with priority 10.
- `renice -5 -p PID` — change running process priority.

## Signals
Messages sent to processes to trigger actions.

| Signal | Number | Meaning |
|--------|--------|---------|
| `SIGTERM` | 15 | Clean termination (default) |
| `SIGKILL` | 9 | Force kill (cannot be caught) |
| `SIGSTOP` | — | Pause process |
| `SIGTSTP` | — | Stop from terminal (`Ctrl+Z`) |

## Viewing & Managing
| Command | Action |
|---------|--------|
| `ps -ef` | All processes, full info |
| `ps -u user` | Processes for a user |
| `top` | Real-time resource monitor |
| `pgrep -l name` | Search by name |
| `kill -9 PID` | Force kill by PID |
| `pkill -15 name` | Signal by name |

## Related
- [[013 - Job Control]]
- [[001 - Linux Overview]]
