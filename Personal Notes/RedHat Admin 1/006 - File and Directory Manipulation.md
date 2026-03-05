# File and Directory Manipulation

## Copying (`cp`)
| Command | Action |
|---------|--------|
| `cp source target` | Copy file |
| `cp -i` | Interactive (asks before overwriting) |
| `cp -r` | Copy directories recursively |

## Moving / Renaming (`mv`)
- `mv source target` — moves or renames.

## Creating
| Command | Action |
|---------|--------|
| `touch filename` | Create empty file (or update timestamp) |
| `mkdir dir_name` | Create directory |
| `mkdir -p a/b/c` | Create nested parent directories |

## Removing
| Command | Action |
|---------|--------|
| `rm file` | Remove file |
| `rm -r dir` | Remove directory recursively |
| `rmdir dir` | Remove **empty** directory only |

## Related
- [[003 - File System Navigation]]
- [[016 - Inodes and Links]]
