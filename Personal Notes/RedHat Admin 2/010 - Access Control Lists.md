# Access Control Lists (ACL)

Allows fine-grained permissions for specific users/groups beyond owner and primary group.

## Commands
| Command | Action |
|---------|--------|
| `getfacl file` | View ACL settings |
| `setfacl -m u:user:rwx file` | Set user permission |
| `setfacl -m g:group:rx file` | Set group permission |
| `setfacl -x u:user file` | Remove specific entry |
| `setfacl -b file` | Remove all ACLs (reset) |

## The Mask
Defines the **maximum** effective permissions for all named users and groups in the ACL.

## Default ACL (Inheritance)
`setfacl -m d:u:user:rw dir` — new files in `dir` automatically inherit this ACL.

> [!TIP]
> A `+` sign in `ls -l` output indicates an ACL is set on the file.

## Related
- [[008 - Ownership and Permissions]]
- [[009 - Special Permissions]]
