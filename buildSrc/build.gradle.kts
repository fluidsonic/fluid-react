import org.jetbrains.kotlin.gradle.plugin.*

plugins {
	kotlin("jvm") version "1.4.31"
}

repositories {
	mavenCentral()
	gradlePluginPortal()
}

sourceSets {
	getByName("main") {
		kotlin.srcDirs("sources")
	}
}


val SourceSet.kotlin
	get() = withConvention(KotlinSourceSet::class) { kotlin }
