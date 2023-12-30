# Thankly

## About
Thankly is a gratitude journaling application made as a passion project and to showcase my abilities.

This page/repo is specifically meant for the Android version of Thankly, see [repositories](#repositories) for the rest.

### Features
Simplified, Thankly is a note-taking application with a bit more visual sugar being the gratitude aspect of it. The main features of this application are:

- Note Entry
- Feed
- Categories/Tags
- Search/Filtering
- Favourites
- Calendar View
- Recycle Bin
- Note History (simple VCS)
- Settings/Preferences

### Usage
The concept of Thankly is fairly simple, after installing (see [Installation](#installation)) it there's no mandatory login/signup needed as it is an offline-first application (meaning everything is stored on and retrievable from your device first), so you can start taking notes right away.

You'll have the ability to create daily entries, edit or deleted them, view their history, favourite specific notes and group them via user-made categories, you'll also be able to view streaks of consecutive days with note entries!

### Repositories
- [Main](https://github.com/ArthurKasparian/thankly)
- [iOS](https://github.com/ArthurKasparian/thankly.iOS)
- [Web Application](https://github.com/ArthurKasparian/thankly.web)

> Note: Some of these repositories might still be private!

---

## Installation

### Mobile
Download the latest APK from [releases](https://github.com/ArthurKasparian/thankly.android/releases) and use it to install Thankly on your mobile device.

### Android Studio
Installation via AS will have instructions as soon as possible.

---

## Codebase

### About
I went against modularising the application for a few reasons, one being the overall simplicity of the codebase, as I project it being mostly complex on the UI layer, and less so in terms of logic; another being a solo developer, there will be no collaboration issues over the course of its work.

### Technologies
The list below is naturally subject to change over time.

#### UI:
- Jetpack Compose
- Compose Navigation

#### State
- ViewModels (MVVM Pattern)
- SavedStateHandle

#### Utility
- Manual DI

#### Data:
- Room Database
- Proto Datastore

### License
This project is licensed under the GNU AGPLv3 License - see [LICENSE](LICENSE) for details.

### Contributing
Thank you for your interest in contributing to [Thankly](https://github.com/ArthurKasparian/thankly)! While the project is not open for external contributions, your feedback is highly valuable. Feel free to open issues for bug reports, feature requests, or any suggestions in the [issues section](https://github.com/ArthurKasparian/thankly.android/issues), or to use the [discussions tab](https://github.com/ArthurKasparian/thankly.android/discussions) for any questions or comments!

I appreciate your understanding as I maintain this project mainly to showcase my abilities and provide a learning resource for fellow developers, and also as a means to be transparent about my practices to potential users.

Happy coding!