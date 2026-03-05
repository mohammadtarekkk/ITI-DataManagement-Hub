# Storage and Partitioning

## Storage Technologies
| Type | Speed | Notes |
|------|-------|-------|
| **HDD** | Slow | Magnetic, low cost |
| **SATA SSD** | Medium | Flash, ~500 MB/s |
| **NVMe SSD** | Fast | PCIe, up to 7000 MB/s |
| **Virtual Disk** | Varies | Software-defined, VMs/Cloud |

## Partitioning Schemes
| Feature | MBR | GPT |
|---------|-----|-----|
| Max Disk Size | 2 TB | 9.4 ZB |
| Max Partitions | 4 Primary (or 3P + 1 Extended) | 128 |
| Era | Legacy (BIOS) | Modern (UEFI) |

## Partitioning Tools
| Tool | Use Case |
|------|----------|
| `fdisk` | Interactive, MBR |
| `gdisk` | Interactive, GPT |
| `parted` | Both MBR/GPT, scriptable, supports resizing |

### `parted` Examples
- `parted /dev/sdb mklabel gpt` — set label.
- `parted /dev/sdb mkpart primary ext4 0% 50%` — create partition.
- `parted /dev/sdb print` — show table.

## Related
- [[013 - Filesystems and Mounting]]
- [[015 - LVM]]
