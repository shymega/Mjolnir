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

  nativeBuildInputs = with pkgs; [ pkg-config protobuf ];
  buildInputs = with pkgs; [ systemd.dev ];

  meta = with lib; {
    description = "";
    homepage = "https://github.com/shymega/mjolnir";
    license = licenses.mit;
  };
}
