{ pkgs, ... }:

{
  packages = [ pkgs.git pkgs.openssl pkgs.pkg-config ];

  languages = {
    nix.enable = true;
    rust.enable = true;
    shell.enable = true;
  };

  services.postgres = {
    enable = true;
    package = pkgs.postgresql;
    initialDatabases = [{ name = "mjolnir_db"; }];
  };

  devcontainer.enable = true;
  difftastic.enable = true;
  dotenv.enable = true;

  pre-commit.hooks = {
    rustfmt.enable = true;
    clippy.enable = true;
    shellcheck.enable = true;
    shfmt.enable = true;
    actionlint.enable = true;
    nixpkgs-fmt.enable = true;
    markdownlint.enable = true;
    statix.enable = true;
  };
  pre-commit.settings.clippy.offline = false;
}
