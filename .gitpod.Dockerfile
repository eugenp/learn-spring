FROM gitpod/workspace-full

LABEL version="0.1.0"
LABEL com.vfrsoft.containers.image.authors="dholtdev@gmail.com"

WORKDIR /workspace/learn-spring

RUN bash scripts/docker_setup.sh
