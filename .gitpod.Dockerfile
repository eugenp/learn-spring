FROM gitpod/workspace-full

LABEL version="0.1.0"
LABEL com.vfrsoft.containers.image.authors="dholtdev@gmail.com"

WORKDIR /

RUN brew install httpie
RUN bash -c "$(curl -fsSL https://raw.githubusercontent.com/ohmybash/oh-my-bash/master/tools/install.sh)"
RUN sed -i 's/OSH_THEME="font"/OSH_THEME="cupcake"/g' home/gitpod/.bashrc
RUN sed i 's/completions=(\n  git\n  composer\n  ssh\n)/completions=(\n  # completion_1\n  composer\n  git\n  ssh\n  # completion_2\n  # completion_n\n)/g'
RUN sed i 's/aliases=(\n  general\n)/aliases=(\n  # alias_1\n  # chmod\n  general\n  # ls\n  # misc\n  # package-manager\n  # alias_2\n  # alias_n\n)/g'
RUN sed i 's/plugins=(\n  git\n  bashmarks\n)/plugins=(\n  # plugin_1\n  bashmarks\n  git\n  # plugin_2\n  # plugin_n\n)/g'
RUN echo "" >> home/gitpod/.bashrc
RUN echo "for i in \$(ls -A $HOME/.bashrc.d/); do source \$HOME/.bashrc.d/\$i; done" >> home/gitpod/.bashrc
RUN echo "" >> home/gitpod/.bashrc
RUN echo "source \"$HOME/.cargo/env\"" >> home/gitpod/.bashrc
