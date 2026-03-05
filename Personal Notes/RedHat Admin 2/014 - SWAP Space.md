# SWAP Space

Virtual memory used when physical **RAM is full**.

## Types
1. **SWAP Partition**: Dedicated disk section.
2. **SWAP File**: A regular file on an existing filesystem used as swap.

## Workflow
1. Create partition or file.
2. `mkswap /dev/sdb3` — format as swap.
3. `swapon /dev/sdb3` — activate.
4. Add to `/etc/fstab` for persistence:
   ```
   /dev/sdb3  none  swap  defaults  0  0
   ```

## Checking
- `free -h` — memory and swap usage.
- `swapon --show` — active swap areas.

## Related
- [[013 - Filesystems and Mounting]]
- [[012 - Storage and Partitioning]]
