# 🆘 SOS RS - Sistema de Alerta e Prevenção

## 📊 Status do Projeto
🚧 **Em desenvolvimento** - Versão 1.0

## 🛠️ Tecnologias Aplicadas
- **Java** (Swing) - Interface gráfica
- **MySQL** - Banco de dados
- **JDBC** - Conexão com banco de dados
- **Git/GitHub** - Versionamento

## 👥 Time de Desenvolvedores
- **William Kurrle de Freitas Wieser** - Desenvolvedor Full Stack

## 🎯 Objetivo do Software
O **SOS RS** é uma plataforma de crise e prevenção para catástrofes naturais no Rio Grande do Sul, surgida após as enchentes de 2024 para:
- **Alertar** usuários sobre áreas de risco em tempo real
- **Centralizar** pedidos de socorro com geolocalização
- **Orientar** a população com números úteis, rotas de fuga e postos de apoio

## ✨ Funcionalidades do Sistema

### Para o Cidadão
- ✅ Visualizar alertas ativos por gravidade (🔴 vermelho, 🟡 amarelo, 🟢 verde)
- ✅ Solicitar socorro com localização e descrição
- ✅ Acessar guias educativos (primeiros socorros, kit emergência)

### Para o Agente da Defesa Civil
- ✅ Cadastrar novos alertas com título, localização e gravidade
- ✅ Visualizar solicitações de socorro pendentes
- ✅ Atender solicitações e atualizar status

### Geral
- ✅ Login com autenticação no banco de dados
- ✅ Acesso como visitante
- ✅ Persistência de dados em MySQL

## 🚀 Como Executar o Projeto

1. **Importar o banco de dados** no MySQL Workbench
2. **Abrir o projeto no NetBeans**
3. **Configurar a conexão** com o banco em `ConexaoDAO.java`
4. **Executar o projeto** (F6)
5. **Credenciais de teste**:
   - Agente: `agente` / `123`
   - Cidadão: `cidadao` / `123`

## 📄 Licença
Este projeto está sob a licença MIT.

---

**Desenvolvido como Projeto Integrador - Curso de Análise e Desenvolvimento de Sistemas**