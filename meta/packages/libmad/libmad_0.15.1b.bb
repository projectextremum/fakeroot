DESCRIPTION = "MPEG Audio Decoder Library"
HOMEPAGE = "http://sourceforge.net/projects/mad/"
BUGTRACKER = "http://sourceforge.net/tracker/?group_id=12349&atid=112349"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
			file://COPYRIGHT;md5=8e55eb14894e782b84488d5a239bc23d \
			file://version.h;beginline=1;endline=8;md5=aa07311dd39288d4349f28e1de516454"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libid3tag"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/mad/libmad-${PV}.tar.gz \
           file://no-force-mem.patch;patch=1 \
           file://add-pkgconfig.patch;patch=1"

S = "${WORKDIR}/libmad-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "-enable-speed --enable-shared"
# The ASO's don't take any account of thumb...
EXTRA_OECONF_append_thumb = " --disable-aso --enable-fpm=default"
EXTRA_OECONF_append_arm = " --enable-fpm=arm"

do_configure_prepend () {
#	damn picky automake...
	touch NEWS AUTHORS ChangeLog
}

ARM_INSTRUCTION_SET = "arm"
