# Cron Scheduling

Schedule tasks to run **automatically at recurring intervals**.

## Crontab Syntax
```
* * * * * command
│ │ │ │ │
│ │ │ │ └── Day of Week (0-7, 0 & 7 = Sun)
│ │ │ └──── Month (1-12)
│ │ └────── Day of Month (1-31)
│ └──────── Hour (0-23)
└────────── Minute (0-59)
```

## Operators
| Symbol | Meaning | Example |
|--------|---------|---------|
| `*` | Every | `* * * * *` = every minute |
| `,` | Multiple values | `1,15` |
| `-` | Range | `1-5` (Mon-Fri) |
| `/` | Increment | `*/5` (every 5 min) |

## Management
| Command | Action |
|---------|--------|
| `crontab -e` | Edit current user's crontab |
| `crontab -l` | List jobs |
| `crontab -r` | Remove all jobs |

## Special Strings
`@reboot`, `@daily`, `@weekly`, `@hourly`

## Access Control
Managed via `/etc/cron.allow` and `/etc/cron.deny`.

## Related
- [[007 - One-Time Scheduling with at]]
- [[012 - Processes and Signals]]
