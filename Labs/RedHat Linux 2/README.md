# RedHat Linux 2 Labs

## Description
This directory contains the completed lab assignments for the **RedHat System Administration II** course. These assignments (submitted via PDF) scale into advanced system daemon configurations and logging infrastructure.

## Implemented Workflows
- **Service Management**: Heavy utilization of `systemctl` to explicitly view daemon statuses, manipulate default system boot targets (`multi-user.target`), and actively stop/start explicit services like `postfix`/`sendmail`.
- **User Communication**: Explored internal network mail exchanges natively within the server (`sendmail`) between users (e.g., rooting to standard users) and verifying receipt.
- **System Logging Infrastructure**: Deep dived into comparing text-based logs (`Rsyslog`) against byte configurations (`Journald`). Re-mapped main logging capabilities modifying `/etc/rsyslog.conf` and actively creating custom severity warning rules (routing logs actively to `/var/log/warnings.log`).

## Files
- Accompanied PDFs (`RedHatAdmin2_lab1.pdf` through `RedHatAdmin2_lab5.pdf`) containing step-by-step evidence.
