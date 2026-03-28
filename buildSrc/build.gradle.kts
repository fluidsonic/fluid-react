plugins {
	`kotlin-dsl`
}

repositories {
	mavenLocal()
	mavenCentral()
	gradlePluginPortal()
}

sourceSets {
	main {
		kotlin.srcDirs("sources")
	}
}
