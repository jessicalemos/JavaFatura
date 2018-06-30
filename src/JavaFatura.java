
/**
 * Escreva a descrição da classe JavaFatura aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.List;
public class JavaFatura implements Serializable{
   private Map<String,Contribuinte> contribuintes;
   private static List<String> concelhos;
   private Contribuinte contribuinte;
   private int id;
   
   /**
    * Devolve a lista com todos os concelhos do interior
    * @return Concelhos do interior
    */
   public static List<String> concelhosDeducao(){
       concelhos = new ArrayList<String>();
       concelhos.add("Castelo Branco");
       concelhos.add("Aguiar da Beira");
       concelhos.add("Manteigas");
       concelhos.add("Pinhel");
       concelhos.add("Sabugal");
       concelhos.add("Trancoso");
       concelhos.add("Vila de Rei");
       concelhos.add("Vila Velha de Ródão");
       concelhos.add("Oleiros");
       concelhos.add("Idanha-a-Nova");
       concelhos.add("Guarda");
       concelhos.add("Gouveia");
       concelhos.add("Belmonte");
       concelhos.add("Almeida");
       concelhos.add("Celorico da Beira");
       concelhos.add("Penamacor");
       concelhos.add("Proença-a-Nova");
       concelhos.add("Pinhel");
       concelhos.add("Seia");
       concelhos.add("Sertã");
       concelhos.add("Covilhã");
       concelhos.add("Mação");
       concelhos.add("Mêda");
       concelhos.add("Figueira de Castelo Rodrigo");
       concelhos.add("Fornos de Algodres");
       concelhos.add("Fundão");
       concelhos.add("Pampilhosa da Serra");
       return concelhos;
    }
    
   /** Construtores */
   
   /**
     * Construtor vazio de uma JavaFatura
     */
   public JavaFatura() {
        this.contribuintes = new TreeMap<String,Contribuinte>();
        this.contribuinte = null;
   }
   
   /**
     * Construtor por parâmetros de uma JavaFatura
     * @param c  Contribuintes
     */
   public JavaFatura(TreeMap<String,Contribuinte> c) {
       this.contribuinte = null;
       this.contribuintes = new TreeMap<String,Contribuinte>();
       for(Contribuinte contribuinte: c.values())
            this.contribuintes.put(contribuinte.getNif(),contribuinte.clone());
       
   }
   
   
   /**
    * Obter o id da próxima fatura a ser registada na aplicação
    * @return id da fatura
    */
   public int getId(){
       return this.id;
   }
   
   /**
    * Obter o contribuinte com a sessão iniciada na aplicação
    * @return contribuinte       Contribuinte com sessão iniciada
    */
   public Contribuinte getContribuinte(){
       return this.contribuinte;
   }
   
   /**
    * Obter o tipo de contribuinte com a sessão iniciada na aplicação
    * @return tipo contribuinte
    */
   public int getTContribuinte(){
       if(contribuinte instanceof ContribuintesColetivos)
            return 0;
       if(contribuinte instanceof ContribuintesIndividuais) 
            return 1;
       return 2;
    }
   
   /**
    * Regista um contribuinte na aplicação
    * @param c           Contribuinte
    */
   public void registaContribuinte(Contribuinte c) throws ContribuinteExistenteException{
       if(this.contribuintes.containsKey(c.getNif())){
           throw new ContribuinteExistenteException("Já existe este contribuidor");
        }
       else this.contribuintes.put(c.getNif(),c);
   }
   
   /**
    * Inicia a sessão de um contribuinte na aplicação
    * @param nif           Nif do contribuinte
    * @param password      Password no contribuinte
    */
   public void login(String nif, String password) throws SemAutorizaçãoException {
       if(this.contribuinte==null){
           if(contribuintes.containsKey(nif)){
               Contribuinte c = contribuintes.get(nif);
               if(password.equals(c.getPassword())){
                   this.contribuinte = c;
                }
                else throw new SemAutorizaçãoException("Dados incorretos");
           }
           else throw new SemAutorizaçãoException("Dados incorretos");
       }
       else throw new SemAutorizaçãoException("Com a sessão iniciada");
    }
   
    /**
    * Fecha a sessão de um contribuinte na aplicação
    */
    public void logout(){
        this.contribuinte = null;
    }
   
   /**
    * Regista uma fatura na aplicação
    * @param fatura         Fatura a registar
    */
   public void registaFatura(Fatura fatura) throws FaturaExisteException, ContribuinteInexistenteException{
       Fatura f = null;
           String nif = fatura.getNifCliente();
           ContribuintesColetivos cc = (ContribuintesColetivos) this.contribuinte;
           if(contribuintes.containsKey(nif)){
               Contribuinte c = contribuintes.get(nif);
               if (c.getFatura().containsValue(fatura) == false){
                   if (cc.getAtividadeEcon().size()>1){
                        c.addPendentes(fatura);
                        cc.addFEmitidas(fatura);
                        c.despesaAtual(fatura.getValor());
                        cc.faturaçãoAtual(fatura.getValor());
                    }
                    else {
                         switch(codigoToNatureza(cc.getAtividadeEcon().get(0))){
                             case "Cabeleireiros": f = new Cabeleireiros();  break;
                             case "Lares": f = new Lares();  break;
                             case "PassesMensais": f = new PassesMensais();  break;
                             case "Educação": f = new Educação();  break;
                             case "DespesasGerais": f = new DespesasGerais();  break;
                             case "RestauraçãoAlojamento": f = new RestauraçãoAlojamento();  break;
                             case "AtividadesVeterinárias": f = new AtividadesVeterinárias();  break;
                             case "Habitação": f = new Habitação();  break;
                             case "ReparaçãoAutomóveis": f = new ReparaçãoAutomóveis();  break;
                             case "ReparaçãoMotociclos": f = new ReparaçãoMotociclos(); break;
                             case "Saúde": f = new Saúde(); break;
                        }
                        f.setNatureza(codigoToNatureza(cc.getAtividadeEcon().get(0)));
                        f.setNifEmitente(fatura.getNifEmitente());
                        f.setDesig(fatura.getDesig());
                        f.setDataDespesa(fatura.getDataDespesa());
                        f.setNifCliente(fatura.getNifCliente());
                        f.setDescricao(fatura.getDescricao());
                        f.setValor(fatura.getValor());
                        f.setIdFatura(fatura.getIdFatura());
                        c.addFatura(f);
                        cc.addFEmitidas(f);
                        c.despesaAtual(f.getValor());
                        cc.faturaçãoAtual(f.getValor());
                    }
                   this.id++;
               }
               else throw new FaturaExisteException ("Fatura já existente");
           }
           else throw new ContribuinteInexistenteException("NIF incorreto");

   }
    
   /**
    * Devolve as despesas que foram emitidas em nome do contribuinte com sessão iniciada
    * @return f        Faturas emitidas em nome do contribuinte
    */
   public List<Fatura> getFaturas() throws FaturaInexistenteException {
          if (this.contribuinte.getFatura().size()!=0){
              ArrayList<Fatura> f = new ArrayList<Fatura>();
              for(Fatura i: this.contribuinte.getFatura().values()){
                  Fatura nova = (Fatura) i;
                  f.add(nova.clone());
                }
              return f;
          }
          else throw new FaturaInexistenteException ("Sem faturas");
   }
   
    /**
    * Devolve as faturas pendentes que foram emitidas em nome do contribuinte com sessão iniciada
    * @return f         Faturas pendentes de um contribuinte
    */
   public List<Fatura> getFaturasPendentes() throws FaturaInexistenteException {
          if (this.contribuinte.getPendentes().size()!=0){
              ArrayList<Fatura> f = new ArrayList<Fatura>();
              for(Fatura i: this.contribuinte.getPendentes().values()){
                  Fatura nova = (Fatura) i;
                  f.add(nova.clone());
                }
              return f;
          }
          else throw new FaturaInexistenteException ("Sem faturas");
   }
       
   /**
    * Associa a classificação de atividade económica a uma fatura
    * @param f                 Fatura a que se pretende associar uma natureza
    * @param natureza          Nova atividade económica da fatura
    */
   public void associaNatureza(Fatura f, String natureza) throws FaturaInexistenteException, AtividadeInexistenteException{
       if (this.contribuinte.getPendentes().containsValue(f) == true){
           Fatura fatura = this.contribuinte.getPendentes().get(f.getIdFatura());
               
            switch(natureza){
                case "Cabeleireiros": f = new Cabeleireiros(); break;
                case "Lares": f = new Lares(); break;
                case "PassesMensais": f = new PassesMensais(); break;
                case "Educação": f = new Educação(); break;
                case "DespesasGerais": f = new DespesasGerais(); break;
                case "RestauraçãoAlojamento": f = new RestauraçãoAlojamento(); break;
                case "AtividadesVeterinárias": f = new AtividadesVeterinárias(); break;
                case "Habitação": f = new Habitação(); break;
                case "ReparaçãoAutomóveis": f = new ReparaçãoAutomóveis(); break;
                case "ReparaçãoMotociclos": f = new ReparaçãoMotociclos(); break;
                case "Saúde": f = new Saúde(); break;
            }                                 
                       f.setNifEmitente(fatura.getNifEmitente());
                       f.setDesig(fatura.getDesig());
                       f.setDataDespesa(fatura.getDataDespesa());
                       f.setNifCliente(fatura.getNifCliente());
                       f.setDescricao(fatura.getDescricao());
                       f.setValor(fatura.getValor());
                       f.setIdFatura(fatura.getIdFatura());
                       f.setNatureza(natureza);
                       ContribuintesColetivos cc = (ContribuintesColetivos) this.contribuintes.get(fatura.getNifEmitente());
               
                       if (cc.getAtividadeEcon().contains(naturezaToCodigo(natureza))){
                           this.contribuinte.removePendentes(fatura);
                           ContribuintesColetivos c = (ContribuintesColetivos) this.contribuintes.get(f.getNifEmitente());
                           c.removeFEmitidas(fatura);
                           this.contribuinte.addFatura(f); 
                           c.addFEmitidas(f);
                       }
                       else throw new AtividadeInexistenteException ("Atividade inexistente");
            }
       else throw new FaturaInexistenteException ("Esta fatura já contém uma atividade económica associada");
   }
   
   /**
    * Altera a classificação de atividade económica a uma fatura
    * @param f                Fatura a que se pretende alterar a natureza
    * @param natureza         Nova atividade económica da fatura
    */
   public void setNatureza(Fatura f, String natureza) throws FaturaInexistenteException, NaturezaInexistenteException, AtividadeInexistenteException{
       if (this.contribuinte.getFatura().containsValue(f) == true){
           if (!(f instanceof Pendentes)){
                Fatura fatura = this.contribuinte.getFatura().get(f.getIdFatura());      
                switch(natureza){
                case "Cabeleireiros": f = new Cabeleireiros(); break;
                case "Lares": f = new Lares(); break;
                case "PassesMensais": f = new PassesMensais(); break;
                case "Educação": f = new Educação(); break;
                case "DespesasGerais": f = new DespesasGerais(); break;
                case "RestauraçãoAlojamento": f = new RestauraçãoAlojamento(); break;
                case "AtividadesVeterinárias": f = new AtividadesVeterinárias(); break;
                case "Habitação": f = new Habitação(); break;
                case "ReparaçãoAutomóveis": f = new ReparaçãoAutomóveis(); break;
                case "ReparaçãoMotociclos": f = new ReparaçãoMotociclos(); break;
                case "Saúde": f = new Saúde(); break;
            }
                       f.setNifEmitente(fatura.getNifEmitente());
                       f.setDesig(fatura.getDesig());
                       f.setDataDespesa(fatura.getDataDespesa());
                       f.setNifCliente(fatura.getNifCliente());
                       f.setDescricao(fatura.getDescricao());
                       f.setValor(fatura.getValor());
                       f.setIdFatura(fatura.getIdFatura());
                       f.setNatureza(natureza);
                    ContribuintesColetivos cc = (ContribuintesColetivos) this.contribuintes.get(fatura.getNifEmitente());

                    if (cc.getAtividadeEcon().contains(naturezaToCodigo(natureza))){   
                       this.contribuinte.removeFaturas(fatura);
                       ContribuintesColetivos c = (ContribuintesColetivos) this.contribuintes.get(f.getNifEmitente());
                       c.removeFEmitidas(fatura);
                       f.setCorreção(1);
                       this.contribuinte.addFatura(f); 
                       c.addFEmitidas(f);
                    }
                    else throw new AtividadeInexistenteException ("Atividade inexistente"); 
                 
           }
           else throw new NaturezaInexistenteException ("Fatura sem natureza associada");
        }
       else throw new FaturaInexistenteException ("Esta fatura ainda nao possui uma atividade económica associada");
   }
   
   /**
    * Converte uma atividade económica em um código
    * @param natureza         Atividade económica que se pretende converter
    * @return codigo          Código associado 
    */
   public String naturezaToCodigo(String natureza){
       String codigo = null;
       switch(natureza){
       case "Cabeleireiros": codigo = "C201"; break;
       case "Lares": codigo = "L502"; break;
       case "PassesMensais": codigo = "PM354"; break;
       case "Educação": codigo = "E478"; break;
       case "DespesasGerais": codigo = "DG678"; break;
       case "RestauraçãoAlojamento": codigo = "RA897"; break;
       case "AtividadesVeterinárias": codigo = "AV292"; break;
       case "Habitação": codigo = "H512"; break;
       case "ReparaçãoAutomóveis": codigo = "RA1278"; break;
       case "ReparaçãoMotociclos":codigo = "RM333"; break;
       case "Saúde": codigo = "S126"; break; 
       }
       return codigo;
    }
    
   /**
    * Converte um código em uma atividade económica
    * @param codigo           Código que se pretende converter
    * @param natureza         Atividade económica associada
    */
    public String codigoToNatureza(String codigo){
       String natureza = null;
       switch(codigo){
       case "C201": natureza = "Cabeleireiros"; break;
       case "L502": natureza = "Lares"; break;
       case "PM354": natureza = "PassesMensais"; break;
       case "E478": natureza = "Educação"; break;
       case "DG678": natureza = "DespesasGerais"; break;
       case "RA897": natureza = "RestauraçãoAlojamento"; break;
       case "AV292": natureza = "AtividadesVeterinárias"; break;
       case "H512": natureza = "Habitação"; break;
       case "RA1278": natureza = "ReparaçãoAutomóveis"; break;
       case "RM333": natureza = "ReparaçãoMotociclos"; break;
       case "S126": natureza = "Saúde"; break; 
       }
       return natureza;
    }
   
    /**
    * Listagem das facturas por contribuinte num determinado intervalo de datas emitidas pela empresa com sessão iniciada
    * @param nif         Nif do contribuinte
    * @param b           Data inicial do intervalo de tempo
    * @param e           Data final do intervalo de tempo
    * @return f          Faturas de um contribuinte emitada pela empresa
    */
   public List<Fatura> faturasContribuinteData(String nif, LocalDate b, LocalDate e) throws ContribuinteInexistenteException, FaturaInexistenteException {
            if (this.contribuintes.containsKey(nif)){
                Contribuinte c = this.contribuintes.get(nif);
                ArrayList<Fatura> f = new ArrayList<Fatura>();
                ContribuintesColetivos cc = (ContribuintesColetivos) this.contribuinte;
                if (c instanceof ContribuintesColetivos){ 
                    ContribuintesColetivos k = (ContribuintesColetivos) c;
                    for(Fatura i: cc.getEmitidas().values()){ 
                        if (i.getNifCliente() == k.getNif() && (i.getDataDespesa().isEqual(b) || i.getDataDespesa().isAfter(b)) && 
                            (i.getDataDespesa().isEqual(e) || i.getDataDespesa().isBefore(e))){
                                f.add(i.clone()); 
                        }
                     }
                 }
                    else{ 
                        ContribuintesIndividuais k = (ContribuintesIndividuais) c;
                        for(Fatura i: cc.getEmitidas().values()){ 
                            if (i.getNifCliente() == k.getNif() && (i.getDataDespesa().isEqual(b) || i.getDataDespesa().isAfter(b)) && 
                            (i.getDataDespesa().isEqual(e) || i.getDataDespesa().isBefore(e))){
                                f.add(i.clone()); 
                            }
                        }
                    }
                    if(f.size()==0) throw new FaturaInexistenteException("Sem faturas");
                    return f;
                }
                else throw new ContribuinteInexistenteException("Contribuinte inexistente");
   }
   
   /**
    * Devolve a lista das faturas emitidas por uma determinada empresa ordenadas por valor para um dado cliente
    * @param nif           Nif do contribuinte
    * @return f            Faturas de um contribuinte emitada pela empresa
    */
   public ArrayList<Fatura> faturasContribuinteValor(String nif) throws ContribuinteInexistenteException, FaturaInexistenteException{
                if (this.contribuintes.containsKey(nif)){
                    Contribuinte c = this.contribuintes.get(nif);
                    ArrayList<Fatura> f = new ArrayList<Fatura>();
                    ContribuintesColetivos cc = (ContribuintesColetivos) this.contribuinte;
                    if (c instanceof ContribuintesColetivos){ 
                        ContribuintesColetivos k = (ContribuintesColetivos) c;
                        for(Fatura i: cc.getEmitidas().values()){ 
                            if (i.getNifCliente() == k.getNif()){
                                f.add(i.clone()); 
                            }
                        }
                        Collections.sort(f,new ValorComparator());
                    }
                else{ 
                    ContribuintesIndividuais k = (ContribuintesIndividuais) c;
                    for(Fatura i: cc.getEmitidas().values()){ 
                        if (i.getNifCliente() == k.getNif()){
                            f.add(i.clone()); 
                        }
                    }
                    Collections.sort(f,new ValorComparator());
                }  
                if(f.size()==0) throw new FaturaInexistenteException("Sem faturas");
                return f;
            }
            else throw new ContribuinteInexistenteException("Contribuinte inexistente");  
   }
   
   /**
    * Devolve a lista das faturas emitidas pela empresa com sessão iniciada ordenadas por valor
    * @return f          Faturas emitidas pela empresa
    */
   public TreeSet<Fatura> getEmitidasValor () throws  FaturaInexistenteException {
           ContribuintesColetivos cc = (ContribuintesColetivos) this.contribuinte;
           if(cc.getEmitidas()!=null){
               TreeSet<Fatura> f = new TreeSet<Fatura>(new ValorComparator());
               for(Fatura i: cc.getEmitidas().values()){
                   f.add(i.clone()); 
                }
                return f;
            }
            else throw new FaturaInexistenteException ("Sem faturas");
   }
   
   /**
    * Devolve a lista das faturas emitidas pela empresa com sessão iniciada ordenadas por data
    * @return f          Faturas emitidas pela empresa
    */
   public TreeSet<Fatura> getEmitidasData() throws FaturaInexistenteException {
            ContribuintesColetivos cc = (ContribuintesColetivos) this.contribuinte;
            if(cc.getEmitidas()!=null){
                TreeSet<Fatura> f = new TreeSet<Fatura>(new DataComparator());
                for(Fatura i: cc.getEmitidas().values()){
                    f.add(i.clone());
                }
                return f;
            }
            else throw new FaturaInexistenteException ("Sem faturas");
   }
   
      /**
    * Devolve a lista das faturas emitidas por uma determinada empresa para o contribuinte com sessão iniciada ordenadas por valor
    * @return f          Faturas emitidas pela empresa
    */
   public ArrayList<Fatura> getFaturasValor (String nif) throws  FaturaInexistenteException,ContribuinteInexistenteException {
               if (!this.contribuintes.containsKey(nif)) throw new ContribuinteInexistenteException ("Contribuinte inexistente");
               ArrayList<Fatura> f = new ArrayList<Fatura>();
               for(Fatura i: this.contribuinte.getFatura().values()){
                   if(i.getNifEmitente().equals(nif)) f.add(i.clone());
                }
                for(Fatura i: this.contribuinte.getPendentes().values()){
                    if(i.getNifEmitente().equals(nif)) f.add(i.clone());
                }
                Collections.sort(f,new ValorComparator());
                if (f.size()==0) throw new FaturaInexistenteException ("Sem faturas");
                return f;
   }
   
   /**
    * Devolve a lista das faturas emitidas por uma determinada empresa para o contribuinte com sessão iniciada ordenadas por data
    * @return f          Faturas emitidas pela empresa
    */
   public ArrayList<Fatura> getFaturasData(String nif) throws FaturaInexistenteException, ContribuinteInexistenteException {
                if (!this.contribuintes.containsKey(nif)) throw new ContribuinteInexistenteException ("Contribuinte inexistente");
                ArrayList<Fatura> f = new ArrayList<Fatura>();
                for(Fatura i: this.contribuinte.getFatura().values()){
                    if(i.getNifEmitente().equals(nif)) f.add(i.clone());
                }
                for(Fatura i: this.contribuinte.getPendentes().values()){
                    if(i.getNifEmitente().equals(nif)) f.add(i.clone());
                }
                Collections.sort(f,new DataComparator());
                if (f.size()==0) throw new FaturaInexistenteException ("Sem faturas");
                return f;
   }
   

   /**
    * Total faturado pela empresa com sessão iniciada
    * @param b               Data inicial do intervalo de tempo
    * @param e               Data final do intervalo de tempo
    * @return total          Valor faturado pela empresa
    */
   public double totalFaturado(LocalDate b, LocalDate e) throws SemAutorizaçãoException{
               double total = 0;
               ContribuintesColetivos cc = (ContribuintesColetivos) this.contribuinte;
               for(Fatura i: cc.getEmitidas().values()){  
                   if((i.getDataDespesa().isEqual(b) || i.getDataDespesa().isAfter(b)) && (i.getDataDespesa().isEqual(e) || i.getDataDespesa().isBefore(e))){
                       total += i.getValor();
                    }
               }
               return total;
   }
   
   /**
    * Devolve o montante de dedução fiscal acumulado pelo agregado familiar
    * @return soma        Montante de dedução fiscal acumulado
    */
   public double deduçãoFiscalAgregado() throws AgregadoInexistenteException{
          ContribuintesIndividuais ci = (ContribuintesIndividuais) this.contribuinte;
          if (ci.getNifs()!=null){
              double soma = deduçãoFiscalIndividual();
              for(String i : ci.getNifs()){
                  Contribuinte a = this.contribuintes.get(i);
                  try{
                      soma += deduçãoFiscal(a);
                   }
                   catch (FaturaInexistenteException e){}
               }
               return soma;
          }
          else throw new AgregadoInexistenteException("Agregado inexistente");
  } 
   
   /**
    * Devolve o montante de dedução fiscal acumulado pelo contribuinte com sessão iniciada
    * @return              Montante de dedução fiscal acumulado
    */
   public double deduçãoFiscalIndividual(){
       try{
          return deduçãoFiscal(this.contribuinte);
        }
       catch (FaturaInexistenteException e){ 
           return 0;
        }
    }
    
   /**
    * Devolve o montante de dedução fiscal acumulado por um contribuinte
    * @param c          Contribuinte
    * @return           Montante de dedução fiscal acumulado
    */ 
   public double deduçãoFiscal(Contribuinte c) throws FaturaInexistenteException{
      if(c instanceof ContribuintesColetivos){
        ContribuintesColetivos cc = (ContribuintesColetivos) c;
        if (cc.getFatura()!=null){
          double d, r;
          d = formulaDeduçãoFiscal(cc.getFatura(),c);
          r = reducaoImposto();
          if (c instanceof EmpresaInterior) return d + d * (cc.getFator() + r);
          else return d + cc.getFator() * d;
        }
        else throw new FaturaInexistenteException ("Fatura inexistente");
      } 
      else{
        ContribuintesIndividuais ci = (ContribuintesIndividuais) c;
        if (ci.getFatura()!=null){
          double d = formulaDeduçãoFiscal(ci.getFatura(),c);
          return d + ci.getCoeffiscal() * d;
        }
        else throw new FaturaInexistenteException ("Fatura inexistente");
      }
   }
   
   /**
    * Fórmula para o cálculo do montante de dedução fiscal
    * @param faturas        Faturas de um dado contribuinte
    * @return acumulado     Montante de dedução fiscal acumulado
    */
   public double formulaDeduçãoFiscal(Map<String,Fatura> faturas, Contribuinte c){
       double somaD = 0,somaS = 0, somaRM = 0, somaC = 0, somaE = 0, somaH = 0, somaRA = 0, somaP = 0, somaR = 0, somaA = 0, somaL = 0,
       acumulado = 0;
       double reducao = reducaoImposto();
       for(Fatura i: faturas.values()){
           if(i.getNatureza().equals("DespesasGerais")){
                  DespesasGerais d = (DespesasGerais) i;
                  double limite;
                  if(c instanceof FamiliaNumerosa) limite = d.getLimite() + d.getLimite()* reducao;
                  else limite = d.getLimite();
                  if (somaD < d.getLimite()){
                       somaD += i.getValor() * d.getTaxa();
                       if (somaD > limite) somaD = limite;
                  }
           }
           else if(i.getNatureza().equals("Saúde")){
                   Saúde d = (Saúde) i;
                   double limite;
                   if(c instanceof FamiliaNumerosa) limite = d.getLimite() + d.getLimite()* reducao;
                   else limite = d.getLimite();
                   if (somaS < d.getLimite()){
                         somaS += i.getValor() * d.getTaxa();
                         if (somaS > limite) somaS = limite;
                   }
           }
           else if(i.getNatureza().equals("ReparaçãoMotociclos")){
                    ReparaçãoMotociclos d = (ReparaçãoMotociclos) i;
                    if (somaRM < d.getLimite()){
                          somaRM += i.getValor() * d.getTaxa();
                          if (somaRM > d.getLimite()) somaRM = d.getLimite();
                    }
           }
           else if(i.getNatureza().equals("Cabeleireiros")){
                    Cabeleireiros d = (Cabeleireiros) i;
                    if (somaC < d.getLimite()){
                          somaC += i.getValor() * d.getTaxa();
                          if (somaC > d.getLimite()) somaC = d.getLimite();
                    }
           }
           else if(i.getNatureza().equals("Educação")){
                   Educação d = (Educação) i;
                   if (somaE < d.getLimite()){
                         somaE += i.getValor() * d.getTaxa();
                         if (somaE > d.getLimite()) somaE = d.getLimite();
                   }
           }
           else if(i.getNatureza().equals("Habitação")){
                    Habitação d = (Habitação) i;
                    if (somaH < d.getLimite()){
                          somaH += i.getValor() * d.getTaxa();
                          if (somaH > d.getLimite()) somaH = d.getLimite();
                    }
           }
           else if(i.getNatureza().equals("RestauraçãoAlojamento")){
                    RestauraçãoAlojamento d = (RestauraçãoAlojamento) i;
                    if (somaR < d.getLimite()){
                         somaR += i.getValor() * d.getTaxa();
                         if (somaR > d.getLimite()) somaR = d.getLimite();
                    }
           }
           else if(i.getNatureza().equals("PassesMensais")){
                    PassesMensais d = (PassesMensais) i;
                    if (somaP < d.getLimite()){
                         somaP += i.getValor() * d.getTaxa();
                         if (somaP > d.getLimite()) somaP = d.getLimite();
                    }
           }
           else if(i.getNatureza().equals("ReparaçãoAutomóvel")){
                    ReparaçãoAutomóveis d = (ReparaçãoAutomóveis) i;
                    if (somaRA < d.getLimite()){
                         somaRA += i.getValor() * d.getTaxa();
                         if (somaRA > d.getLimite()) somaRA = d.getLimite();
                    }
           }
           else if(i.getNatureza().equals("AtividadesVeterinárias")){
                       AtividadesVeterinárias d = (AtividadesVeterinárias) i;
                        if (somaA < d.getLimite()){
                           somaA += i.getValor() * d.getTaxa();
                           if (somaA > d.getLimite()) somaA = d.getLimite();
                       }
           }
           else if(i.getNatureza().equals("Lares")){
                   Lares d = (Lares) i;
                   if (somaL < d.getLimite()){
                         somaL += i.getValor() * d.getTaxa();
                         if (somaL > d.getLimite()) somaL = d.getLimite();
                   }
           }
       }
       acumulado = somaD + somaS + somaRM + somaC + somaE + somaH + somaR + somaP + somaRA + somaA + somaL;
       return acumulado;
   }
   
   /**
    * Devolve a lista ordenada pela despesa de cada contribuinte (para retirar os 10 melhores)
    * @return top10        Despesa de cada contribuinte
    */
   public ArrayList<Contribuinte> top10() throws ContribuinteException{
       if(this.contribuintes.size()>=10){
           ArrayList<Contribuinte> top10 = new ArrayList<Contribuinte>();
           
           for(Contribuinte c : this.contribuintes.values()){
               top10.add(c.clone());
            }
            Collections.sort(top10,new ContribuinteComparator());
            return top10;
       }
       else throw new ContribuinteException("Sem contribuinte suficientes");
   }
   
   /**
    * Número de contribuintes coletivos registados na aplicação
    * @return c      Número de contribuintes
    */
   public int numContribuintesColetivos(){
       int c = 0;
       for(Contribuinte i: this.contribuintes.values())
            if(i instanceof ContribuintesColetivos) c++;
        return c;
    }
   
    /**
    * Número de contribuintes individuais registados na aplicação
    * @return c      Número de contribuintes
    */
     public int numContribuintesIndividuais(){
       int c = 0;
       for(Contribuinte i: this.contribuintes.values())
            if(i instanceof ContribuintesIndividuais) c++;
        return c;
    }
    
    /**
     * Devolve as faturas de uma dada atividade económica do contribuinte com sessão
     * @param natureza      Atividade económica
     * @return faturas      Faturas do contribuinte
     */
    public ArrayList<Fatura> getFaturasNatureza(String natureza) throws FaturaInexistenteException{
            ArrayList<Fatura> faturas = new ArrayList<Fatura>();
            for(Fatura f: this.contribuinte.getFatura().values()){
                if(f.getNatureza().equals(natureza)) {
                    Fatura nova = (Fatura) f;
                    faturas.add(nova.clone());
                }
            }
            if(faturas.size()==0) throw new FaturaInexistenteException("Não existem faturas desta natureza");
            return faturas;
    }
    
    /**
     * Devolve as faturas cuja atividade económica foi alterada pelos contribuintes
     * @return faturas      Faturas dos contribuintes
     */
    public ArrayList<Fatura> faturasAlteradas() throws ContribuinteInexistenteException,FaturaInexistenteException{
        ArrayList<Fatura> faturas = new ArrayList<Fatura>();
        if(this.contribuintes!=null){
        for(Contribuinte c: this.contribuintes.values()){
            for(Fatura f: c.getFatura().values()){ 
                if(f.getCorreção()==1) faturas.add(f.clone());
            }
        }
        if(faturas.size()==0) throw new FaturaInexistenteException("Sem faturas alteradas");
        return faturas;
        }
        else throw new ContribuinteInexistenteException("Sem contribuintes");
    }
    
   /**
    * Devolve a arvore ordenada pela faturacão de cada uma das X empresas (retirar os X melhores)
    * @param x          Número de empresas
    * @return topX      Arvore com a faturacão de cada empresa
    */
   public TreeSet<ContribuintesColetivos> topX(int x) throws ContribuinteException{
       if(numContribuintesColetivos()>=x){
           int i=0;
           TreeSet<ContribuintesColetivos> topX = new TreeSet<ContribuintesColetivos>(new ContribuinteCComparator());
           for(Contribuinte c : this.contribuintes.values()){
               if(c instanceof ContribuintesColetivos){
                   ContribuintesColetivos cc = (ContribuintesColetivos) c;
                   topX.add(cc.clone());
                }
            }
            return topX;
       }
       else throw new ContribuinteException("Sem contribuintes suficientes");
   }
   
   /**
    * Calcula o montande de dedução fiscal das X empresas com maior faturacão
    * @param cc              Arvore com a faturacão das X empresas
    * @param empresas        Número de empresas
   */
   public void deduçaoTopX(TreeSet<ContribuintesColetivos> cc,int empresas){
       try{
            int conta = 0;
            for(ContribuintesColetivos i: cc){
               if(conta<empresas){
                   Contribuinte c = (Contribuinte) i;
                   System.out.println("A empresa com o nif: " + i.getNif() + " tem uma deduçao fiscal de: " + deduçãoFiscal(c));    
                }
                else break;
                conta++;
            }
       }
       catch (FaturaInexistenteException e){
           System.out.println(e.getMessage());
       }
  }

   /**
    * Devolve o valor de redução aplicado a empresas do interior e a familias numerosas
    * @param Valor da redução
    */
   public double reducaoImposto(){
       double reducao = 0;
       if (this.contribuinte instanceof FamiliaNumerosa){
           FamiliaNumerosa c = (FamiliaNumerosa) this.contribuinte;
               reducao = c.getNumFilhos() * c.getReduçao();
                
        }
        else if (this.contribuinte instanceof EmpresaInterior){
                    EmpresaInterior c = (EmpresaInterior) this.contribuinte;
                    reducao = c.getReduçao();
                }
       return reducao;   
    }

   
   /**
    * Grava o estado da aplicação em ficheiro
    * @param ficheiro
    */
   public void gravaEstado() throws IOException{
       ObjectOutputStream o = new ObjectOutputStream (new FileOutputStream("JavaFatura.data"));
       o.writeObject(this);
       o.flush();
       o.close();
    }
   
    /**
     * Inicia a aplicação com os dados guardados em ficheiro
     * @return JavaFatura
     */
    public static JavaFatura initApp() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("JavaFatura.data"));
        JavaFatura jf = (JavaFatura) ois.readObject();

        ois.close();
        return jf;
    }
       
   /**
    * Imprime a informação da JavaFatura
    * @return String com a informação
    */
   public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Contribuintes: ");
        for(Contribuinte c : this.contribuintes.values())
            sb.append(c.getNif());
        sb.append("Contribuinte com sessão iniciada: ");
        sb.append(this.contribuinte);
        return sb.toString();
   }
   
   /**
    * Devolve todas as familias numerosas registadas na aplicação
    * @return Familias numerosas
    */
       public List<FamiliaNumerosa> daoReduçaoFamilias() throws FamíliasInexistenteException{
           if(this.contribuintes.values().stream()
                    .filter(h -> h instanceof FamiliaNumerosa)
                    .map(Contribuinte::clone)
                    .map(h -> (FamiliaNumerosa) h)
                    .collect(Collectors.toList()).size()==0) throw new FamíliasInexistenteException("Nao existem familias numerosas"); 
           return this.contribuintes.values().stream()
                    .filter(h -> h instanceof FamiliaNumerosa)
                    .map(Contribuinte::clone)
                    .map(h -> (FamiliaNumerosa) h)
                    .collect(Collectors.toList());
        }
        
   /**
    * Devolve todas as empresas do interior registadas na aplicação
    * @return Empresas do interior
    */
        public List<EmpresaInterior> daoReduçaoEmpresas() throws EmpresasInexistenteException{
           if(this.contribuintes.values().stream()
                    .filter(h -> h instanceof EmpresaInterior).map(Contribuinte::clone)
                    .map(h -> (EmpresaInterior) h)
                    .collect(Collectors.toList()).size()==0) throw new EmpresasInexistenteException("Nao existem empresas do interior");
           return this.contribuintes.values().stream()
                    .filter(h -> h instanceof EmpresaInterior)
                    .map(Contribuinte::clone)
                    .map(h -> (EmpresaInterior) h)
                    .collect(Collectors.toList());
        }
        
         /**
    * Devolve todas as empresas do interior registadas na aplicação
    * @return Empresas do interior
    */
        public List<IncentivoFiscal> daoReduçao() throws IncentivoInexistenteException{
           if(this.contribuintes.values().stream()
                    .filter(h -> h instanceof IncentivoFiscal).map(Contribuinte::clone)
                    .map(h -> (IncentivoFiscal) h)
                    .collect(Collectors.toList()).size()==0) throw new IncentivoInexistenteException("Nao existem contribuintes com incentivo fiscal");
           return this.contribuintes.values().stream()
                    .filter(h -> h instanceof IncentivoFiscal)
                    .map(Contribuinte::clone)
                    .map(h -> (IncentivoFiscal) h)
                    .collect(Collectors.toList());
        }
    
}