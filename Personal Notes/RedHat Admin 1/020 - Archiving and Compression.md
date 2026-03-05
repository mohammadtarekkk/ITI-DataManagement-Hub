# Archiving and Compression

## `tar` (Tape Archive)
Groups multiple files into one `.tar` archive (no compression by default).

| Flag | Action |
|------|--------|
| `c` | Create archive |
| `x` | Extract |
| `t` | List contents |
| `v` | Verbose |
| `f` | Specify filename |

- Create: `tar -cvf archive.tar file1 file2`
- Extract: `tar -xvf archive.tar`

## Compression Utilities
| Tool | Extension | Compress | Decompress | View |
|------|-----------|----------|------------|------|
| `compress` | `.Z` | `compress file` | `uncompress` | `zcat` |
| `gzip` | `.gz` | `gzip file` | `gunzip` | `gzcat` |
| `bzip2` | `.bz2` | `bzip2 file` | `bunzip2` | `bzcat` |
| `zip` | `.zip` | `zip target.zip sources` | `unzip` | `unzip -l` |

> [!TIP]
> Combine with tar: `tar -czvf archive.tar.gz folder/` (create compressed archive).

## Related
- [[006 - File and Directory Manipulation]]
- [[017 - Disk Space Commands]]
