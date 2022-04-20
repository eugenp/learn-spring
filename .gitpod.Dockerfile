FROM gitpod/workspace-full

LABEL version="0.1.0"
LABEL com.vfrsoft.containers.image.authors="dholtdev@gmail.com"

WORKDIR /workspace/learn-spring

RUN /usr/bin/env bash -c ' \
  source scripts/docker_setup.sh; \
  install_dependencies; \
  install_oh_my_bash; \
  do_config_replacements; \
  source_all_modules; \
  add_pieces_from_original_config'
