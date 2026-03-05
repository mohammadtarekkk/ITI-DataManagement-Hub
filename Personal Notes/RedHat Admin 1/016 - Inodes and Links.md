# Inodes and Links

## Inodes (Index Nodes)
Linux identifies files by a unique **Inode number**, not by name.

### Inode Contains:
1. File type & permissions.
2. Number of hard links.
3. Owner UID & Group GID.
4. Timestamps (access, modification).
5. File location on disk.

- `ls -i file` — view inode number.

## How Operations Affect Inodes
- **`cp`**: Creates a **new** inode (independent copy).
- **`mv`** (same filesystem): Same inode, new directory entry (just a rename).

## Links
### Soft Link (Symbolic)
- Points to the **path** of the original file.
- **Can** cross partition boundaries.
- Deleting original → **orphaned link** (broken).
- `ln -s target link_name`

### Hard Link
- Points to the **same inode** as the original.
- Increments the link count.
- **Cannot** cross partition boundaries.
- Deleting original → file still accessible via other hard links.
- `ln target link_name`

## Related
- [[006 - File and Directory Manipulation]]
- [[017 - Disk Space Commands]]
