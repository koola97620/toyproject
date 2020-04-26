package me.jdragon.toy.controller;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/01/31.
 * @project toy
 * @description
 */
public class testtt {

  @Test
  public void tete() {
    CalculateService calculateService = new CalculateService();
    calculateService.calculate();
  }

  private class CalculateService {

    public void calculate() {
      AddCounter addCounter = new AddCounter();
      addCounter.add();
    }

  }

  private class AddCounter {

    public void add() {
      
    }
  }
}
