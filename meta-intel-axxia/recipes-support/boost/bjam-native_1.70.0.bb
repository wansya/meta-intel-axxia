require boost-${PV}.inc

SUMMARY = "Portable Boost.Jam build tool for boost"
SECTION = "devel"

inherit native

SRC_URI += "file://bjam-native-build-bjam.debug.patch \
	    file://build.sh-use-DNDEBUG-also-in-debug-builds.patch \
"

do_compile() {
    ./bootstrap.sh --with-toolset=gcc
}

do_install() {
    install -d ${D}${bindir}/
    # install unstripped version for bjam
    install -c -m 755 bjam.debug ${D}${bindir}/bjam
}
