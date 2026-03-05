# Linux Boot Sequence

The system follows a specific order to reach a usable state:

## 1. BIOS / UEFI
- **POST** (Power-On Self-Test): Detects hardware.
- Selects boot device.
- **Legacy (BIOS)**: Reads MBR (first 512 bytes).
- **UEFI**: Loads EFI executables from ESP (EFI System Partition).

## 2. Boot Loader (GRUB2)
- Allows kernel selection.
- Reads config: `/etc/grub2.cfg`.
- Edit defaults: `/etc/default/grub`.
- Regenerate: `grub2-mkconfig -o /boot/grub2/grub.cfg`.

## 3. Kernel
- Loads drivers, initializes memory.
- Mounts root filesystem (read-only initially).
- Starts the **init** process.

## 4. Systemd (PID 1)
- First process in user space.
- Resolves the default [[004 - Systemd Targets|target]] and starts services.

## Related
- [[002 - Systemd and Unit Types]]
- [[004 - Systemd Targets]]
