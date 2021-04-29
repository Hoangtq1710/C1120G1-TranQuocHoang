package com.soren.controller;

import com.soren.model.Customer;
import com.soren.model.Transaction;
import com.soren.model.TransactionType;
import com.soren.service.CustomerService;
import com.soren.service.TransactionService;
import com.soren.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping("/transaction")
    public String getHome(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("listTransaction", this.transactionService.findAll(pageable));
        model.addAttribute("listTransactionType", this.transactionTypeService.findAll());
        model.addAttribute("listCustomer", this.customerService.findAll());
        return "list";
    }

    @PostMapping("/transaction/filter")
    public String getFilterList(@RequestParam(name = "tranType") Integer transactionTypeId,
                                @RequestParam(name = "customerId") Integer customerId,
                                Model model, Pageable pageable){
        TransactionType transactionType = this.transactionTypeService.findById(transactionTypeId);
        Customer customer = this.customerService.findById(customerId);

        Page<Transaction> listTransaction = this.transactionService.getListFilter(transactionType, customer, pageable);

        model.addAttribute("listTransaction", listTransaction);
        model.addAttribute("customerId", customerId);
        model.addAttribute("tranType", transactionTypeId);
        model.addAttribute("listTransactionType", this.transactionTypeService.findAll());
        model.addAttribute("listCustomer", this.customerService.findAll());

        return "list";
    }

    @GetMapping("/transaction/view")
    public String viewTransaction(@RequestParam(name = "id") String id, Model model){
        Transaction transaction = this.transactionService.findById(id);
        model.addAttribute("transaction", transaction);
        return "view";
    }

    @GetMapping("/transaction/create")
    public String showCreateForm(Model model){
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("listCustomer", this.customerService.findAll());
        model.addAttribute("listTransactionType", this.transactionTypeService.findAll());
        return "create";
    }

    @PostMapping("/transaction/create")
    public String createTransaction(@Valid @ModelAttribute(name = "transaction") Transaction transaction, BindingResult bindingResult,
                                    Model model, RedirectAttributes redirect){
        new Transaction().validate(transaction, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("transaction", transaction);
            model.addAttribute("listCustomer", this.customerService.findAll());
            model.addAttribute("listTransactionType", this.transactionTypeService.findAll());
            return "create";
        } else {
            this.transactionService.save(transaction);
            redirect.addFlashAttribute( "message",
                                        "Transaction has ID "+transaction.getTransactionId()+" was added!");
            return "redirect:/transaction";
        }
    }

    @GetMapping("/transaction/delete")
    public String showDeleteForm(@RequestParam(name = "id") String id, Model model){
        Transaction transaction = this.transactionService.findById(id);
        model.addAttribute("transaction", transaction);
        return "delete";
    }

    @PostMapping("/transaction/delete")
    public String deleteTransaction(@RequestParam(name = "id") String id, RedirectAttributes redirect){
        Transaction transaction = this.transactionService.findById(id);
        if (transaction != null) {
            this.transactionService.deleteById(id);
            redirect.addFlashAttribute( "message",
                                        "Transaction ID "+transaction.getTransactionId()+" was deleted!");
        }
        return "redirect:/transaction";
    }
}
