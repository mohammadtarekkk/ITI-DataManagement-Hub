# Filesystems and Mounting

## Common Filesystems
| Filesystem | Notes |
|------------|-------|
| **ext4** | Default for many distros, journaling |
| **XFS** | High-performance, large files |
| **Btrfs** | Snapshots, pooling |
| **vfat/FAT32** | Cross-platform, 4 GB file limit |
| **NTFS** | Windows native, slower on Linux (user-space driver) |

## Formatting
`mkfs.ext4 /dev/sdb1` or `mkfs.xfs /dev/sdb2`

## Identification
- `blkid` — show UUIDs.
- `lsblk -f` — show filesystems and mount points.

## Mounting
- `mount /dev/sdb1 /mnt` — temporary mount.
- `umount /mnt` — unmount.

## Persistent Mounts (`/etc/fstab`)
```
[UUID]  [Mount Point]  [Type]  [Options]  [Dump]  [Pass]
```
| Field | Description |
|-------|-------------|
| UUID | From `blkid` |
| Mount Point | Target directory |
| Type | ext4, xfs, swap |
| Options | `defaults` (rw, suid, exec, auto) |
| Dump | 0 (no backup) or 1 |
| Pass | 0 (skip fsck), 1 (root), 2 (other) |

- `mount -a` — test fstab without rebooting.

## Related
- [[012 - Storage and Partitioning]]
- [[014 - SWAP Space]]
