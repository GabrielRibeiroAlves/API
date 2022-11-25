package apicarros.API.service;

import apicarros.API.entity.Pessoa;
import apicarros.API.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PessoaDetailService implements UserDetailsService {


    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaDetailService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pessoa pessoa = new Pessoa();
        pessoaRepository.findByEmail(email);

       if(pessoa == null)
       {
           throw new UsernameNotFoundException("Usuario nao encontrado pelo email");
       }
        return pessoa;
    }
}
