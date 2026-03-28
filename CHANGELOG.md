# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/).

## [0.14.0] - 2026-03-28

### Changed

- Kotlin updated to 2.3.20
- Gradle wrapper updated to 9.4.1
- fluid-gradle plugin updated to 3.0.0
- React updated to ~19.1.0
- React Router updated to ~7.5.0 (v7, packages merged)
- react-helmet-async updated to ~3.0.0
- kotlinx-coroutines updated to 1.10.2
- html-webpack-plugin updated to ~5.6.6
- Replaced deprecated `react` property with `React` throughout codebase
- Changed delegating component overloads from `crossinline` to `noinline` (Kotlin 2.x stricter enforcement)

### Removed

- KFC webpack plugin (no longer needed with Kotlin 2.3)
- `history` npm dependency (React Router v7 manages history internally)

### Deprecated

- `ReactGlobal.render()` — removed in React 19, use `createRoot()` instead

### Added

- KDoc on all public APIs
- Unit tests for utility functions and core builders
- CLAUDE.md project documentation
- CHANGELOG.md
- GitHub Actions CI workflow

### Fixed

- Module descriptions in build files (were all "FIXME")
- `@RDsl` annotations removed from functions/properties (Kotlin 2.x: DSL markers only apply to types)
- `definedExternally` explicit import for Kotlin 2.3 compatibility
