# Package Management (RPM & YUM)

## RPM (Red Hat Package Manager)
Manages `.rpm` packages directly.

| Command | Action |
|---------|--------|
| `rpm -i pkg.rpm` | Install |
| `rpm -e pkg` | Remove (erase) |
| `rpm -U pkg.rpm` | Upgrade |
| `rpm -qa` | Query all installed |
| `rpm -qf /path/file` | Which package owns this file? |

- RPMs are signed with **GPG keys** for security.

## YUM (Yellowdog Updater, Modified)
Frontend for RPM that **resolves dependencies automatically**.
- Repos defined in `/etc/yum.repos.d/`.

| Command | Action |
|---------|--------|
| `yum search keyword` | Search for package |
| `yum install pkg` | Install |
| `yum remove pkg` | Uninstall |
| `yum update` | Update all |
| `yum provides file` | Find package containing a file |
| `yum clean all` | Clear cache |

## Related
- [[019 - Searching for Files]]
- [[001 - Linux Overview]]
