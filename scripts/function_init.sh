#!/usr/bin/env bash
echo "Defining functions..."

init_source_dir() {
  echo "Initializing source_dir..."
  source=${BASH_SOURCE[0]}
  while [ -h "$source" ]; do # resolve $source until the file is no longer a symlink
    source_dir=$( cd -P "$( dirname "$source" )" >/dev/null 2>&1 && pwd )
    source=$(readlink "$source")
    [[ $source != /* ]] && source=$source_dir/$source # if $SOURCE was a relative symlink, we need to resolve it relative to the path where the symlink file was located
  done
  source_dir=$( cd -P "$( dirname "$source" )" >/dev/null 2>&1 && pwd )
  echo "Initializing source_dir: ${source_dir}"
  echo "-------------------------------------------------------------------"
  echo ""
}

init_source_dir && echo "source_dir: ${source_dir}" && source $source_dir/env.sh

install_oh_my_bash() {
  echo "Installing Oh My Bash!..."
  bash -c "$(curl -fsSL https://raw.githubusercontent.com/ohmybash/oh-my-bash/master/tools/install.sh)"
  echo "Finished installing Oh My Bash!"
  echo "-------------------------------------------------------------------"
  echo ""
}

do_config_replacements() {
  echo "Making config replacements (config_path: ${config_path})..."
  sed -i 's/OSH_THEME="font"/OSH_THEME="cupcake"/g' "${config_path}"
  sed -i 's/completions=(\n  git\n  composer\n  ssh\n)/completions=(\n  # completion_1\n  composer\n  git\n  ssh\n  # completion_2\n  # completion_n\n)/g' "${config_path}"
  sed -i 's/aliases=(\n  general\n)/aliases=(\n  # alias_1\n  # chmod\n  general\n  # ls\n  # misc\n  # package-manager\n  # alias_2\n  # alias_n\n)/g' "${config_path}"
  sed -i 's/plugins=(\n  git\n  bashmarks\n)/plugins=(\n  # plugin_1\n  bashmarks\n  git\n  # plugin_2\n  # plugin_n\n)/g' "${config_path}"
  sed -i 's/OSH_THEME="font"/OSH_THEME="cupcake"/g' "${config_path}"
  sed -i 's/OSH_THEME="font"/OSH_THEME="cupcake"/g' "${config_path}"
  sed -i 's/OSH_THEME="font"/OSH_THEME="cupcake"/g' "${config_path}"
  echo "Finished making config replacements:"
  echo "-------------------------------------------------------------------"
  echo "$(cat $HOME/.bashrc)"
  echo "-------------------------------------------------------------------"
  echo ""
}

source_all_modules() {
  echo "Sourcing all modules in $HOME/.bashrc.d..."
  echo "" >> "${config_path}"
  echo "for i in \$(ls -A \$HOME/.bashrc.d/); do source \$HOME/.bashrc.d/\$i; done" >> "${config_path}"
  echo "Finished sourcing all modules in $HOME/.bashrc.d:"
  echo "-------------------------------------------------------------------"
  echo "$(cat $HOME/.bashrc)"
  echo "-------------------------------------------------------------------"
  echo ""
}

add_pieces_from_original_config() {
  echo "Adding pieces from the original config..."
  echo "" >> "${config_path}"
  echo "source \"\$HOME/.cargo/env\"" >> "${config_path}"
  echo "Finished adding pieces from the original config:"
  echo "-------------------------------------------------------------------"
  echo "$(cat $HOME/.bashrc)"
  echo "-------------------------------------------------------------------"
  echo ""
}

install_dependencies() {
  echo "Installing dependencies..."
  brew update

  # Add `brew install` statements here.
  brew install httpie
  echo "Finished installing dependencies."
  echo "-------------------------------------------------------------------"
  echo ""
}

echo "Finished defining functions."
echo "-------------------------------------------------------------------"
echo ""
