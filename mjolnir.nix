{ lib
, pkgs ? import <nixpkgs>
, rustPlatform
,
}:
rustPlatform.buildRustPackage {
  name = "mjolnir";

  src = lib.cleanSource ./.;

  cargoLock = {
    lockFile = ./Cargo.lock;
    allowBuiltinFetchGit = true;
  };

  PKG_CONFIG_PATH = "${pkgs.openssl.dev}/lib/pkgconfig";

  nativeBuildInputs = with pkgs; [ pkg-config openssl.dev systemd.dev ];
  buildInputs = [ ];

  meta = with lib; {
    description = "";
    homepage = "https://github.com/shymega/mjolnir";
    license = licenses.mit;
  };
}
