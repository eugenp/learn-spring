FROM gitpod/workspace-full

LABEL version="0.1.0"
LABEL com.vfrsoft.containers.image.authors="dholtdev@gmail.com"

WORKDIR /

RUN brew install httpie
RUN bash -c "$(curl -fsSL https://raw.githubusercontent.com/ohmybash/oh-my-bash/master/tools/install.sh)"
RUN sed -i 's/OSH_THEME="font"/OSH_THEME="cupcake"/g' home/gitpod/.bashrc
RUN echo "" >> home/gitpod/.bashrc
RUN echo "for i in \$(ls -A $HOME/.bashrc.d/); do source \$HOME/.bashrc.d/\$i; done" >> home/gitpod/.bashrc
RUN echo "" >> home/gitpod/.bashrc
RUN echo "source \"$HOME/.cargo/env\"" >> home/gitpod/.bashrc
