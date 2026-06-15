# Ethiopian Calendar Wear OS Watch Face

This project contains two Wear OS applications:

- `watchface`: a code-free Watch Face Format (WFF) watch face.
- `calendar-provider`: an Ethiopian calendar complication data source.

## Run

1. Open the project in Android Studio.
2. Install both `watchface` and `calendar-provider` on a Wear OS 4+ emulator or watch.
3. Select **Ethiopian Calendar** as the active watch face.

The watch face requests **Ethiopian Date** as its default lower complication,
so the current Ethiopian date appears automatically when both APKs are
installed. Wear OS may preserve an older empty complication assignment after an
upgrade; remove and add the face again to apply the new default.

The provider uses `android.icu.util.EthiopicCalendar`, so conversion follows the
calendar implementation shipped with Android rather than a hand-written date
offset.

## Build from the command line

```powershell
.\gradlew.bat :watchface:assembleDebug :calendar-provider:assembleDebug
```
