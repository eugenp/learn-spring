#!/usr/bin/env bash

init_source_dir && source $source_dir/env.sh

install_oh_my_bash() {
  bash -c "$(curl -fsSL https://raw.githubusercontent.com/ohmybash/oh-my-bash/master/tools/install.sh)"
}

do_config_replacements() {
  sed -i 's/OSH_THEME="font"/OSH_THEME="cupcake"/g' "${config_path}"
  sed -i 's/completions=(\n  git\n  composer\n  ssh\n)/completions=(\n  # completion_1\n  composer\n  git\n  ssh\n  # completion_2\n  # completion_n\n)/g' "${config_path}"
  sed -i 's/aliases=(\n  general\n)/aliases=(\n  # alias_1\n  # chmod\n  general\n  # ls\n  # misc\n  # package-manager\n  # alias_2\n  # alias_n\n)/g' "${config_path}"
  sed -i 's/plugins=(\n  git\n  bashmarks\n)/plugins=(\n  # plugin_1\n  bashmarks\n  git\n  # plugin_2\n  # plugin_n\n)/g' "${config_path}"
  sed -i 's/OSH_THEME="font"/OSH_THEME="cupcake"/g' "${config_path}"
  sed -i 's/OSH_THEME="font"/OSH_THEME="cupcake"/g' "${config_path}"
  sed -i 's/OSH_THEME="font"/OSH_THEME="cupcake"/g' "${config_path}"
}

source_all_modules() {
  echo "" >> "${config_path}"
  echo "for i in \$(ls -A \$HOME/.bashrc.d/); do source \$HOME/.bashrc.d/\$i; done" >> "${config_path}"
}

add_pieces_from_original_config() {
  echo "" >> "${config_path}"
  echo "source \"\$HOME/.cargo/env\"" >> "${config_path}"
}

install_dependencies() {
  brew update

  # Add `brew install` statements here.
  brew install httpie
}

init_source_dir() {
  source=${BASH_SOURCE[0]}
  while [ -h "$source" ]; do # resolve $source until the file is no longer a symlink
    source_dir=$( cd -P "$( dirname "$source" )" >/dev/null 2>&1 && pwd )
    source=$(readlink "$source")
    [[ $source != /* ]] && source=$source_dir/$source # if $SOURCE was a relative symlink, we need to resolve it relative to the path where the symlink file was located
  done
  source_dir=$( cd -P "$( dirname "$source" )" >/dev/null 2>&1 && pwd )
}
